package cc.conyli.entity;

public class Address {

    private String detail;

    public Address() {
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Address{" +
                "detail='" + detail + '\'' +
                '}';
    }
}
