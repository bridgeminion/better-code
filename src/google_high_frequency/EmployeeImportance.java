package google_high_frequency;

import java.util.*;

public class EmployeeImportance {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    public int getImportanceDFS(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }
        Employee emp = map.get(id);

        return emp.importance + helper(map.get(id).subordinates, map) ;
    }

    private int helper(List<Integer> employees, Map<Integer, Employee> map) {
        int result = 0;
        if (!employees.isEmpty()) {
            for (int empId : employees) {
                Employee emp = map.get(empId);
                result += emp.importance;
                result += helper(emp.subordinates, map);
            }
        }

        return result;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }
        Employee emp = map.get(id);
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(emp);
        int result = 0;
        while (!queue.isEmpty()) {
            Employee e = queue.poll();
            result += e.importance;
            for (int i : e.subordinates) {
                queue.offer(map.get(i));
            }
        }

        return result;
    }


}
