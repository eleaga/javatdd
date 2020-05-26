public class User {
    public Integer age;
    public String firstName;
    public String lastName;
    public String cpf;
    public String cep;

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

    public String validateCEP() {
        return cep.replaceAll("\\D+","");
    }

    public boolean isEmailValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

}
