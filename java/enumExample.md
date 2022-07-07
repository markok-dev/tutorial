http://www.angelikalanger.com/Articles/EffectiveJava/28.Enums/28.Enums.html    
    
    enum Mode {
        CREATE("create"),
        EDIT("edit");

        private String name;

        Mode(String name) {
            this.name = name;
        }

        public static Mode getByName(String name) {
            for (Mode mode : values()) {
                if (mode.name.equals(name)) {
                    return mode;
                }
            }
            return null;
        }

        public String getName() {
            return name;
        }

    }
