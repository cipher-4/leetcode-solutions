import pandas as pd

def department_highest_salary(employee: pd.DataFrame, department: pd.DataFrame) -> pd.DataFrame:
    
    merged = pd.merge(employee,department,left_on='departmentId',right_on='id',how='left')

    merged = merged[merged['salary'] == merged.groupby('departmentId')['salary'].transform('max')]

    return merged[['name_y','name_x','salary']].rename(columns={
        'name_y' : 'Department',
        'name_x' : 'Employee',
        'salary' : 'Salary'
    })