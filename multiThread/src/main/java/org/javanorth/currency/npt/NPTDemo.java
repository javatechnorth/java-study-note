package org.javanorth.currency.npt;

import java.util.*;

public class NPTDemo {

    public static void main(String[] args) {
//        Employee employee = new Employee();
//        Group group = new Group();
//        employee.setGroup(group);
//
//        employee.getGroup().getDepartment().getDepartmentName();

//        if (employee != null){
//            if(employee.getGroup() != null){
//                if(employee.getGroup().getDepartment() != null){
//                    String departmentName = employee.getGroup().getDepartment().getDepartmentName();
//                }
//            }
//        }
        
//        if(callSuccess()){
//
//        }

        Map<String,String> map= new HashMap<>();
        map.get("test").equals("test");

//       Objects.requireNonNull(map.get("test"), "can not be null");


//        String s = Optional.ofNullable(employee)
//                .map(Employee::getGroup)
//                .map(Group::getDepartment)
//                .map(Department::getDepartmentName).orElse("Default");
//
//        String s1 = Optional.ofNullable(employee)
//                .map(Employee::getGroup)
//                .map(Group::getDepartment)
//                .map(Department::getDepartmentName).orElseGet(() -> {
//                    return "Supplier default";
//                });

//        "knownObject".equals(unknownObject)
//        Optional
//        Optional.ofNullable(employee)
//                .map(Employee::getGroup)
//                .map(Group::getDepartment)
//                .map(Department::getDepartmentName).orElseThrow();

    }

    public static int count(){
        Integer integer = null;
        return integer;
    }

    public static Boolean callSuccess(){
        return null;
    };

    public static String testString(String str) throws Exception {
        if (str == null){
            throw new Exception("param can't be null");
        }
        return str;
    }


}
