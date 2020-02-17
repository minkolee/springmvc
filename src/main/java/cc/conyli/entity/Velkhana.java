package cc.conyli.entity;


import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.Date;

public class Velkhana {

    @Pattern(regexp = "\\w{7,20}", message = "怪物名称在7-20个字符之间")
    private String monsterName;

    @DecimalMax(value = "3245.06", message = "不能超过大金冠长度3245.06")
    @DecimalMin(value = "2284.52", message = "不能小于小金冠长度2284.52")
    private BigDecimal size;

    @Past(message = "必须是过去的日期")
    private Date releaseDate;

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "monsterName='" + monsterName + '\'' +
                ", size=" + size +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
