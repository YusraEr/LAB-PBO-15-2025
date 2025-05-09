package login_app.models;

public class Profile {
    private String fullName;
    private int age;
    private String hobby;
    private String nickName;

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void showProfile() {
        System.out.println("Nama Lengkap : " + fullName);
        System.out.println("Nick Name    : " + nickName);
        System.out.println("Umur         : " + age);
        System.out.println("Hobby        : " + hobby);
    }
}

