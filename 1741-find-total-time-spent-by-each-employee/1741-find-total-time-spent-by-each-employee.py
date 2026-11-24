import pandas as pd

def total_time(employees: pd.DataFrame) -> pd.DataFrame:

    employees['sub'] = employees['out_time'] - employees['in_time']
    employees = employees.groupby(['event_day','emp_id'])['sub'].sum().reset_index()

    return employees[['event_day','emp_id','sub']].rename(columns={
        'event_day' : 'day',
        'sub' : 'total_time'
    })