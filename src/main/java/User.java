public class User {
    public Integer age;
    public String firstName;
    public String lastName;
    public String cpf;

    public boolean validateAge(){
        age = this.getAge();
        if(age>=18) {
            return true;
        }
        return false;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Integer getAge() {
        return this.age;
    }

    public String validateCPF() {
        return cpf.replaceAll("\\D+","");
    }

    public String  profile () {
        String profile = null;
        if (age < 18) {
            profile = "teen";
        }
        else if(age >= 18 && age < 64){
            profile = "adult";
        }
        else{
            profile = "senior";
        }

        return profile;
    }

    public boolean isEmailValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

}
