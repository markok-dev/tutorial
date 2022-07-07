    public String encode() ...... {
        String s = StringUtil.join(new Object[] {
            StringUtil.nullvalue(wert1, "-"),
            organisationId,
            StringUtil.nullvalue(wert2, "-"),
            StringUtil.nullvalue(wert3, "-")
        }, "/");
        return Base32.encode(s.getBytes("UTF-8")).toLowerCase();
    }
	
wert1, wert2, wert3 können beliebige Werte sein. Bsp: kundennummer, organisation usw.    