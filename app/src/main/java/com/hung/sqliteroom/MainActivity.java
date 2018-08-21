package com.hung.sqliteroom;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hung.sqliteroom.dao.MyDatabase;
import com.hung.sqliteroom.entity.Department;
import com.hung.sqliteroom.entity.Employee;
import com.hung.sqliteroom.entity.EmployeeView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private Button mBtnAddEmployee;
    private Button mBtnGetAllEmployees;
    private Button mBtnUpdateEmployee;
    private Button mBtnDeleteEmployee;
    private Button mBtnGetAllDepartments;
    //
    MyDatabase mDatabase;
    private Button mBtnGetEmployeeById;
    private Button mBtnGetEmployeeByName;
    private Button mBtnAddDepartments;
    private Button mBtnGetAllEmployeeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        //==============================  get Database connect ================================
        String DATABASE_NAME = "MyDatabase";
        mDatabase = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, DATABASE_NAME)
                .addCallback(new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        // http://www.sqlitetutorial.net/sqlite-inner-join/
                        Log.d(TAG, "******************* CREATE VIEW EmployeeView ");
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
                    }
                })
                .build();


    }

    private void initView() {

        mBtnAddEmployee = (Button) findViewById(R.id.btn_add_employee);
        mBtnGetAllEmployees = (Button) findViewById(R.id.btn_all_employees);
        mBtnGetEmployeeById = (Button) findViewById(R.id.btn_get_employee_by_id);
        mBtnGetEmployeeByName = (Button) findViewById(R.id.btn_get_employee_by_name);
        mBtnUpdateEmployee = (Button) findViewById(R.id.btn_update_employee);
        mBtnDeleteEmployee = (Button) findViewById(R.id.btn_delete_employee);

        mBtnAddDepartments = (Button) findViewById(R.id.btn_add_departments);
        mBtnGetAllDepartments = (Button) findViewById(R.id.btn_get_all_departments);
        mBtnGetAllEmployeeView = (Button) findViewById(R.id.btn_get_all_employee_view);

        Log.d(TAG, "======================== aaaaaaaaaaaaaaaaaaaaaa");
        //
        mBtnAddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "======================== mBtnAddEmployee");
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "======================== insert employeess to Employee Table");
                        //
                        List<Employee> employees = new ArrayList<Employee>();
                        Employee e;
                        e = new Employee("Hungbeo", 12, 1,Calendar.getInstance().getTime(),Calendar.getInstance().getTime(),1);
                        employees.add(e);

                        e = new Employee("HungGay", 13, 3,Calendar.getInstance().getTime(),Calendar.getInstance().getTime(),2);
                        employees.add(e);
                        e = new Employee("SonX", 11, 2,Calendar.getInstance().getTime(),Calendar.getInstance().getTime(),3);
                        employees.add(e);
                        e = new Employee("Hao", 17, 1,Calendar.getInstance().getTime(),Calendar.getInstance().getTime(),1);
                        employees.add(e);
                        //
                        mDatabase.getEmployeeDAO().insertAll(employees);
                    }
                });

                thread.start();

            }
        });

        mBtnGetAllEmployees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "======================mBtnGetAllEmployees");
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<Employee> employees = mDatabase.getEmployeeDAO().getAll();
                        Log.d(TAG, "======================== get all from Employee Table");
                        for (Employee e : employees) {
                            Log.d(TAG, e.toString());
                        }
                    }
                });
                thread.start();
            }
        });

        mBtnGetEmployeeById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "======================mBtnGetEmployeeById");
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Employee employee = mDatabase.getEmployeeDAO().findById(2);
                        Log.d(TAG, "======================== get Employee by id");
                        if (employee == null) {
                            Log.d(TAG, "not found Id");
                        } else {
                            Log.d(TAG, employee.toString());
                        }
                    }
                });
                thread.start();
            }
        });

        mBtnGetEmployeeByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "======================mBtnGetEmployeeByName");
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        /**
                         *  special character: %
                         */
                        List<Employee> employees = mDatabase.getEmployeeDAO().findByName("%hung%");
                        Log.d(TAG, "======================== findByName(\"%hung%\")");
                        for (Employee e : employees) {
                            Log.d(TAG, e.toString());
                        }
                    }
                });
                thread.start();
            }
        });


        mBtnUpdateEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "======================mBtnUpdateEmployee");
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // cach 1:
                        Employee e = new Employee("Update1", 13, 3,Calendar.getInstance().getTime(),Calendar.getInstance().getTime(),2);
                        e.id = 1;
                        mDatabase.getEmployeeDAO().update(e);
                        Log.d(TAG, "======================== update buy id");
                        Log.d(TAG, e.toString());
                        // cach 2
                        mDatabase.getEmployeeDAO().update2(2, "update2", 28);

                    }
                });
                thread.start();
            }
        });

        mBtnAddDepartments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "======================mBtnAddDepartments");
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "======================== insert employeess to Employee Table");
                        //
                        List<Department> departments = new ArrayList<Department>();
                        Department d;
                        d = new Department(1,"IT",1);
                        departments.add(d);
                        d = new Department(2,"Finance",3);
                        departments.add(d);
                        d = new Department(3,"Sale",5);
                        departments.add(d);
                        //
                        mDatabase.getDepartmentDAO().insertAll(departments);
                    }
                });

                thread.start();
            }
        });

        mBtnGetAllDepartments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "======================mBtnGetAllEmployees");
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<Department> departments = mDatabase.getDepartmentDAO().getAll();
                        Log.d(TAG, "======================== get all from Employee Table");
                        for (Department d : departments) {
                            Log.d(TAG, d.toString());
                        }
                    }
                });
                thread.start();
            }
        });

        mBtnGetAllEmployeeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "======================mBtnGetAllEmployeeView");
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<EmployeeView> employeeViews = mDatabase.getEmployeeViewDAO().getAll();
                        Log.d(TAG, "======================== get all from Employee Table");
                        for (EmployeeView d : employeeViews) {
                            Log.d(TAG, d.toString());
                        }
                    }
                });
                thread.start();
            }
        });
    }
}
