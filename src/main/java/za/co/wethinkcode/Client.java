//package za.co.wethinkcode;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//
//@Entity
//@Table(name="client")
//public class Client {
//    @Id
//    @Column(name="id")
//    private Integer id;
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//    @NotNull
//    @Size(min = 3, max = 15)
//    @Column(name="name")
//    private String name;
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//}
