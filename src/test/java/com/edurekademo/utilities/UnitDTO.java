package com.edurekademo.utilities;

public class UnitDTO {

        private Integer empID;
        private String empName; 
        private Integer deptID; 
        private String dateofJoining;
        private Double spare; 
        private Object spare2; 
        
        public Integer getEmpID() {
                return empID;
        }
        public void setEmpID(Integer empID) {
                this.empID = empID;
        }
        public String getEmpName() {
                return empName;
        }
        public void setEmpName(String empName) {
                this.empName = empName;
        }
        public Integer getDeptID() {
                return deptID;
        }
        public void setDeptID(Integer deptID) {
                this.deptID = deptID;
        }
        public String getDateofJoining() {
                return dateofJoining;
        }
        public void setDateofJoining(String dateofJoining) {
                this.dateofJoining = dateofJoining;
        }
        public Double getSpare() {
                return spare;
        }
        public void setSpare(Double spare) {
                this.spare = spare;
        }
        public Object getSpare2() {
                return spare2;
        }
        public void setSpare2(Object spare2) {
                this.spare2 = spare2;
        }
        
        public UnitDTO() { 
        }
}
