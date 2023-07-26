package bstu.it.Avs.basejava;

import java.util.Objects;

public class WrapperString {
    private String str1;
    public void replace (char oldchar, char newchar){
        str1=str1.replace(oldchar,newchar);
    }


    @Override
    public String toString() {
        return "WrapperString{" +
                "str1='" + str1 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrapperString that = (WrapperString) o;
        return Objects.equals(str1, that.str1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str1);
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public WrapperString(String str1) {
        this.str1 = str1;
    }
}
