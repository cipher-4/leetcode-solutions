import pandas as pd

def game_analysis(activity: pd.DataFrame) -> pd.DataFrame:

    activity = activity.sort_values(by='event_date')

    activity = activity.drop_duplicates(subset=['player_id'],keep='first')

    return activity[['player_id', 'event_date']].rename(columns={
        'event_date' : 'first_login'
    })
    