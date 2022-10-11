package platform.business;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "snippets")
public class Snippet {

    @JsonIgnore
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String code;
    @Column
    private String date;

    public Snippet() {
    }

    public Snippet(Long id, String code, String date) {
        this.id = id;
        this.code = code;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Snippet)) return false;
        Snippet snippet = (Snippet) o;
        return Objects.equals(getId(), snippet.getId()) &&
                Objects.equals(getCode(), snippet.getCode()) &&
                Objects.equals(getDate(), snippet.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode(), getDate());
    }
}
