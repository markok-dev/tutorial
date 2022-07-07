package com.scopevisio.erp.server.userrepository.ldap;

import com.scopevisio.erp.core.util.Comparison;
import org.bouncycastle.crypto.generators.Argon2BytesGenerator;
import org.bouncycastle.crypto.params.Argon2Parameters;
import org.bouncycastle.util.Arrays;

import java.util.Base64;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Argon2PasswordEncoder {

    private static final Logger log = Logger.getLogger(Argon2PasswordEncoder.class.getName());
    private final Base64.Encoder b64encoder = Base64.getEncoder().withoutPadding();
    private final Base64.Decoder b64decoder = Base64.getDecoder();

    class ArgonConfig {
        public int version;
        public int iterations;
        public int memory;
        public int parallelism;
        public int hashLength;
        public int saltLength;

        public ArgonConfig(int version, int iterations,int memory, int parallelism, int hashLength, int saltLength ) {
            this.version = version;
            this.iterations = iterations;
            this.memory = memory;
            this.parallelism = parallelism;
            this.hashLength = hashLength;
            this.saltLength = saltLength;
        }

    }
    private ArgonConfig parameter;

    /**
     * Sets default values
     */
    public Argon2PasswordEncoder() {
        this.parameter = new ArgonConfig(Argon2Parameters.ARGON2_VERSION_13, 2, 15729, 1, 32, 16);
    }

    public Argon2PasswordEncoder(ArgonConfig parameter) {
        this.parameter = parameter;
    }

    public String encode(String rawPassword) {
        byte[] salt = new byte[parameter.saltLength];
        new Random().nextBytes(salt);
        byte[] hash = new byte[parameter.hashLength];

        Argon2Parameters parameters = new Argon2Parameters.Builder(Argon2Parameters.ARGON2_id)
                .withVersion(parameter.version)
                .withIterations(parameter.iterations)
                .withMemoryAsKB(parameter.memory)
                .withSalt(salt)
                .withParallelism(parameter.parallelism)
                .build();

        Argon2BytesGenerator gen = new Argon2BytesGenerator();
        gen.init(parameters);
        gen.generateBytes(rawPassword.toCharArray(), hash);
        //String hexOutput = toHex(result);
        String encodedFormOutput = encode(hash, parameters);
        return encodedFormOutput;
    }

    public boolean matches(String rawPassword, String encodedPassword) {
        if (Comparison.isVoid(rawPassword) || Comparison.isVoid(encodedPassword)) {
            return false;
        }
        Argon2Hash decoded;
        try {
            decoded = decode(encodedPassword);
        } catch (IllegalArgumentException execption) {
            log.log(Level.WARNING, "Malformed password hash", execption);
            return false;
        }
        byte[] hashBytes = new byte[decoded.getHash().length];
        Argon2BytesGenerator generator = new Argon2BytesGenerator();
        generator.init(decoded.getParameters());
        generator.generateBytes(rawPassword.toCharArray(), hashBytes);
        return Arrays.areEqual(hashBytes, decoded.getHash());
    }

    /**
     * https://github.com/spring-projects/spring-security/blob/006b9b960797d279b31cf8c8d16f1549c5632b2c/crypto/src/main/java/org/springframework/security/crypto/argon2/Argon2EncodingUtils.java
     * @param hash
     * @param parameters
     * @return
     * @throws IllegalArgumentException
     */
    private String encode(byte[] hash, Argon2Parameters parameters) throws IllegalArgumentException {
        StringBuilder stringBuilder = new StringBuilder();
        switch (parameters.getType()) {
            case Argon2Parameters.ARGON2_d:
                stringBuilder.append("$argon2d");
                break;
            case Argon2Parameters.ARGON2_i:
                stringBuilder.append("$argon2i");
                break;
            case Argon2Parameters.ARGON2_id:
                stringBuilder.append("$argon2id");
                break;
            default:
                throw new IllegalArgumentException("Invalid algorithm type: " + parameters.getType());
        }
        stringBuilder.append("$v=").append(parameters.getVersion()).append("$m=").append(parameters.getMemory())
                .append(",t=").append(parameters.getIterations()).append(",p=").append(parameters.getLanes());
        if (parameters.getSalt() != null) {
            stringBuilder.append("$").append(b64encoder.encodeToString(parameters.getSalt()));
        }
        stringBuilder.append("$").append(b64encoder.encodeToString(hash));
        return stringBuilder.toString();
    }

    private static String toHex(byte[] result) {
        StringBuilder sb = new StringBuilder();
        for (byte b : result) {
            String s = String.format("%02x", b & 0xff);
            sb.append(s);
        }
        return sb.toString();
    }

    private Argon2Hash decode(String encodedHash) throws IllegalArgumentException {
        Argon2Parameters.Builder paramsBuilder;
        String[] parts = encodedHash.split("\\$");

        if (parts.length < 4) {
            throw new IllegalArgumentException("Invalid encoded Argon2-hash");
        }
        int currentPart = 1;
        switch (parts[currentPart++]) {
            case "argon2d":
                paramsBuilder = new Argon2Parameters.Builder(Argon2Parameters.ARGON2_d);
                break;
            case "argon2i":
                paramsBuilder = new Argon2Parameters.Builder(Argon2Parameters.ARGON2_i);
                break;
            case "argon2id":
                paramsBuilder = new Argon2Parameters.Builder(Argon2Parameters.ARGON2_id);
                break;
            default:
                throw new IllegalArgumentException("Invalid algorithm type: " + parts[0]);
        }
        if (parts[currentPart].startsWith("v=")) {
            paramsBuilder.withVersion(Integer.parseInt(parts[currentPart].substring(2)));
            currentPart++;
        }
        String[] performanceParams = parts[currentPart++].split(",");
        if (performanceParams.length != 3) {
            throw new IllegalArgumentException("Amount of performance parameters invalid");
        }
        if (!performanceParams[0].startsWith("m=")) {
            throw new IllegalArgumentException("Invalid memory parameter");
        }
        paramsBuilder.withMemoryAsKB(Integer.parseInt(performanceParams[0].substring(2)));
        if (!performanceParams[1].startsWith("t=")) {
            throw new IllegalArgumentException("Invalid iterations parameter");
        }
        paramsBuilder.withIterations(Integer.parseInt(performanceParams[1].substring(2)));
        if (!performanceParams[2].startsWith("p=")) {
            throw new IllegalArgumentException("Invalid parallelity parameter");
        }
        paramsBuilder.withParallelism(Integer.parseInt(performanceParams[2].substring(2)));
        paramsBuilder.withSalt(b64decoder.decode(parts[currentPart++]));
        return new Argon2Hash(b64decoder.decode(parts[currentPart]), paramsBuilder.build());
    }

    public class Argon2Hash {

        private byte[] hash;

        private Argon2Parameters parameters;

        Argon2Hash(byte[] hash, Argon2Parameters parameters) {
            this.hash = Arrays.clone(hash);
            this.parameters = parameters;
        }

        public byte[] getHash() {
            return Arrays.clone(this.hash);
        }

        public void setHash(byte[] hash) {
            this.hash = Arrays.clone(hash);
        }

        public Argon2Parameters getParameters() {
            return this.parameters;
        }

        public void setParameters(Argon2Parameters parameters) {
            this.parameters = parameters;
        }

    }

    public static void main(String[] args) {
        Argon2PasswordEncoder encoder = new Argon2PasswordEncoder();
        String passwod = "password";
        String encodedPassword = encoder.encode(passwod);
        System.out.println("encoded password: " + encodedPassword);

        boolean matches = encoder.matches(passwod, encodedPassword);
        System.out.println("matches: " + matches);
    }

}
