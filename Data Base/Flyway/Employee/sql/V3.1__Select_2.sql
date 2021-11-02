select Manager_id
from (
         SELECT COUNT(Worker_id) as worker_count,Manager_id
         FROM subordination
         GROUP BY Manager_id) cm
where cm.worker_count > 3;