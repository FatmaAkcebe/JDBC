public class Queries {//Bu sınıf, SQL sorgularını bir yerde saklamak için kullanılır. Sadece sorguların metin hali burada tanımlanır.

    public static final String[] QUERIES = new String[42];
    static {
        QUERIES[1] = "SELECT * FROM employees INNER JOIN dept_emp ON employees.emp_no = dept_emp.emp_no WHERE dept_no = 'D001';";
        QUERIES[2] = "SELECT employees.* FROM employees INNER JOIN dept_emp ON employees.emp_no = dept_emp.emp_no INNER JOIN departments ON dept_emp.dept_no = departments.dept_no WHERE departments.dept_name = 'Human Resources';";
        QUERIES[3] = "SELECT AVG(salary) AS average_salary FROM salaries;";
        QUERIES[4] = "SELECT AVG(s.salary) AS average_salary FROM employees e INNER JOIN salaries s ON e.emp_no = s.emp_no WHERE e.gender = 'F';";
        QUERIES[5] = "SELECT AVG(s.salary) AS average_salary FROM employees e INNER JOIN salaries s ON e.emp_no = s.emp_no WHERE e.gender = 'M';";
        QUERIES[6] = "SELECT e.*, s.salary FROM employees e JOIN dept_emp de ON e.emp_no = de.emp_no JOIN departments d ON de.dept_no = d.dept_no JOIN salaries s ON e.emp_no = s.emp_no WHERE d.dept_name = 'Sales' AND s.salary > 70000;";
        QUERIES[7] = "SELECT e.* FROM employees e INNER JOIN salaries s ON e.emp_no = s.emp_no WHERE s.salary BETWEEN 50000 AND 100000;";
        QUERIES[8] = "SELECT de.dept_no, AVG(s.salary) AS average_salary FROM dept_emp de JOIN salaries s ON de.emp_no = s.emp_no GROUP BY de.dept_no;";
        QUERIES[9] = "SELECT dept_name, AVG(salary) AS avg_salary FROM departments JOIN dept_emp ON departments.dept_no = dept_emp.dept_no JOIN salaries ON dept_emp.emp_no = salaries.emp_no GROUP BY departments.dept_no;";
        QUERIES[10] = "SELECT d.dept_no, d.dept_name, AVG(s.salary) AS average_salary FROM employees e JOIN dept_emp de ON e.emp_no = de.emp_no JOIN salaries s ON e.emp_no = s.emp_no JOIN departments d ON de.dept_no = d.dept_no GROUP BY d.dept_no, d.dept_name;";
        QUERIES[11] = "SELECT emp_no, salary, from_date, to_date FROM salaries WHERE emp_no = '10102' ORDER BY from_date;";
        QUERIES[12] = "SELECT emp_no, salary, to_date FROM salaries WHERE emp_no = '10102' ORDER BY to_date;";
        QUERIES[13] = "SELECT * FROM employees JOIN salaries ON employees.emp_no = salaries.emp_no ORDER BY salary DESC LIMIT 1;";
        QUERIES[14] = "SELECT emp_no, salary, to_date FROM salaries WHERE (emp_no, to_date) IN (SELECT emp_no, MAX(to_date) FROM salaries GROUP BY emp_no);";
        QUERIES[15] = "SELECT e.first_name, e.last_name, MAX(s.salary) AS highest_salary FROM employees e INNER JOIN dept_emp de ON e.emp_no = de.emp_no INNER JOIN departments d ON de.dept_no = d.dept_no INNER JOIN salaries s ON e.emp_no = s.emp_no WHERE d.dept_name = 'Sales' GROUP BY e.first_name, e.last_name ORDER BY highest_salary DESC LIMIT 1;";
        QUERIES[16] = "SELECT e.first_name, e.last_name, MAX(s.salary) AS max_salary FROM employees e INNER JOIN dept_emp de ON e.emp_no = de.emp_no INNER JOIN departments d ON de.dept_no = d.dept_no INNER JOIN salaries s ON e.emp_no = s.emp_no WHERE d.dept_name = 'Research' GROUP BY e.first_name, e.last_name ORDER BY max_salary DESC LIMIT 1;";
        QUERIES[17] = "SELECT d.dept_name AS department, e.first_name, e.last_name, MAX(s.salary) AS max_salary FROM employees e INNER JOIN dept_emp de ON e.emp_no = de.emp_no INNER JOIN departments d ON de.dept_no = d.dept_no INNER JOIN salaries s ON e.emp_no = s.emp_no GROUP BY d.dept_name ORDER BY max_salary DESC;";
        QUERIES[18] = "SELECT d.dept_name AS department, e.first_name, e.last_name, AVG(s.salary) AS avg_salary FROM employees e INNER JOIN dept_emp de ON e.emp_no = de.emp_no INNER JOIN departments d ON de.dept_no = d.dept_no INNER JOIN salaries s ON e.emp_no = s.emp_no GROUP BY department ORDER BY avg_salary DESC;";
        QUERIES[19] = "SELECT first_name, last_name, hire_date FROM employees WHERE hire_date < '1990-01-01' ORDER BY first_name ASC, last_name ASC;";
        QUERIES[20] = "SELECT first_name, last_name, hire_date FROM employees WHERE hire_date BETWEEN '1985-01-01' AND '1989-12-31' ORDER BY hire_date ASC;";
        QUERIES[21] = "SELECT first_name, last_name, hire_date, salary FROM employees WHERE hire_date BETWEEN '1985-01-01' AND '1989-12-31' AND department = 'Sales' AND emp_no IN (SELECT emp_no FROM salaries) ORDER BY salary DESC;";
        QUERIES[22] = "SELECT COUNT(gender) AS Male_Count FROM employees WHERE gender = 'M';";
        QUERIES[23] = "SELECT COUNT(gender) AS Female_Count FROM employees WHERE gender = 'F';";
        QUERIES[24] = "SELECT gender, COUNT(*) AS count FROM employees GROUP BY gender;";
        QUERIES[25] = "SELECT COUNT(emp_no) AS Total_Employees FROM employees;";
        QUERIES[26] = "SELECT COUNT(DISTINCT first_name) AS Unique_Names FROM employees;";
        QUERIES[27] = "SELECT COUNT(DISTINCT dept_name) AS Unique_Departments FROM departments;";
        QUERIES[28] = "SELECT de.dept_no, COUNT(*) AS employee_count FROM dept_emp de GROUP BY de.dept_no;";
        QUERIES[29] = "SELECT * FROM employees WHERE hire_date <= DATE_SUB('1990-02-20', INTERVAL 5 YEAR);";
        QUERIES[30] = "SELECT * FROM employees WHERE first_name = 'Annemarie' AND last_name = 'Redmiles';";
        QUERIES[31] = "SELECT * FROM employees e INNER JOIN salaries s ON e.emp_no = s.emp_no INNER JOIN titles t ON e.emp_no = t.emp_no WHERE e.first_name = 'Annemarie' AND e.last_name = 'Redmiles';";
        QUERIES[32] = "SELECT e.emp_no, e.first_name, e.last_name, e.birth_date, e.gender, e.hire_date, d.dept_name AS department_name, t.title, s.salary FROM employees e JOIN dept_manager dm ON e.emp_no = dm.emp_no JOIN departments d ON dm.dept_no = d.dept_no JOIN titles t ON e.emp_no = t.emp_no JOIN salaries s ON e.emp_no = s.emp_no WHERE d.dept_no = 'D005';";
        QUERIES[33] = "SELECT e.emp_no, e.first_name, e.last_name, e.birth_date, e.gender, e.hire_date, t.title, s.salary FROM employees e JOIN titles t ON e.emp_no = t.emp_no JOIN salaries s ON e.emp_no = s.emp_no WHERE e.hire_date > '1994-02-24' AND s.salary > 50000;";
        QUERIES[34] = "SELECT e.emp_no, e.first_name, e.last_name, e.birth_date, e.gender, e.hire_date FROM employees e JOIN dept_manager dm ON e.emp_no = dm.emp_no JOIN departments d ON dm.dept_no = d.dept_no JOIN titles t ON e.emp_no = t.emp_no WHERE d.dept_name = 'Sales' AND t.title = 'Manager';";
        QUERIES[35] = "SELECT employees.first_name, employees.last_name FROM employees JOIN dept_manager ON employees.emp_no = dept_manager.emp_no WHERE dept_manager.dept_no = 'D005';";
        QUERIES[36] = "SELECT * FROM employees ORDER BY birth_date;";
        QUERIES[37] = "SELECT * FROM employees WHERE hire_date BETWEEN '1992-04-01' AND '1992-04-30';";
        QUERIES[38] = "SELECT DISTINCT dept_no FROM dept_emp WHERE emp_no = '10102';";
        QUERIES[39] = "SELECT * FROM employees ORDER BY birth_date;";
        QUERIES[40] = "SELECT * FROM employees WHERE hire_date BETWEEN '1992-04-01' AND '1992-04-30';";
        QUERIES[41] = "SELECT DISTINCT dept_no FROM dept_emp WHERE emp_no = '10102';";
    }
}
