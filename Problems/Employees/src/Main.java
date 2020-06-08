class Employee {

    protected String name;
    protected String email;
    protected int experience;

    public Employee(String name, String email, int experience) {
        this.name = name;
        this.email = email;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public String getEmail() {
        return email;
    }
}

class Developer extends Employee {

    protected String[] skills;
    protected String mainLanguage;

    public Developer(String name, String email, int experience, String mainLanguage, String[] skills) {
        super(name, email, experience);
        this.mainLanguage = mainLanguage;
        this.skills = skills.clone();
    }

    public String[] getSkills() {
        return skills.clone();
    }

    public String getMainLanguage() {
        return mainLanguage;
    }
}

class DataAnalyst extends Employee {

    protected boolean phd;
    protected String[] methods;

    public DataAnalyst(String name, String email, int experience, boolean phd, String[] methods) {
        super(name, email, experience);
        this.phd = phd;
        this.methods = methods.clone();
    }

    public String[] getMethods() {
        return methods.clone();
    }

    public boolean isPhd() {
        return phd;
    }
}