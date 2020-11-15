import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private int department;
    private String name;

    public Employee(int id, int department, String name) {
        super();
        this.id = id;
        this.department = department;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public int getDepartment() {
        return department;
    }
    public String getName() {
        return name;
    }

}

class Java8_GroupingBy {

 public static void main(String[] args) {

//  List < Employee > employees = Arrays.asList(
//   new Employee(1, 10, "Chandra"), new Employee(1, 20, "Rajesh"),
//   new Employee(1, 30, "Rahul"), new Employee(1, 20, "Ramana"));
//
//  Map < Integer, List < Employee >> byDept = employees.stream().collect(
//   Collectors.groupingBy(Employee::getDepartment));
//  
//  for(Map.Entry< Integer, List < Employee >> i: byDept.entrySet()){
//      System.out.println(i.getKey()+"=>"+i.getValue());
// }
  
//  byDept.forEach((k, v) -> System.out.println("DeptId:" +k +"   " +
//   ((List < Employee > ) v).stream().map(m -> m.getName())
//   .collect(Collectors.joining(","))));
 }

}
public class MultiMapExample {


   
}