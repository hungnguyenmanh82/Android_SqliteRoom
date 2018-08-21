package com.hung.sqliteroom.entity;

import androidx.room.*;

/**
 *      // http://www.sqlitetutorial.net/sqlite-inner-join/
         db.execSQL("DROP VIEW IF EXISTS EmployeeView");
         db.execSQL("CREATE VIEW EmployeeView" +
                     " AS SELECT " +
                     "e.id AS id," +
                     "e.name AS name," +
                     "e.age AS age," +
                     "m.name AS managerName," +
                     "d.name AS deptname " +
                     "FROM Employee e " +
                     "INNER JOIN Department d ON d.id = e.deptId " +
                     "INNER JOIN Employee m ON m.id = e.managerId "
                     );
 */
@Entity
public class EmployeeView {
	/**
	 * primary key
	 */
	@PrimaryKey
	public int id;
	public String name;
	public int age;

	// http://www.sqlitetutorial.net/sqlite-inner-join/
	@ColumnInfo(name = "deptname")
	public String deptName;

	@ColumnInfo(name = "managerName")
	public String managerName;

	public EmployeeView(){}

	public int getId() {
		return id;
	}

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public void setId(int id) {
		this.id = id;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

    @Override
    public String toString() {
        return "{"+ this.id + "," + this.name + "," + this.age + "," + this.managerName  + "," + this.deptName +"},";
    }
}
