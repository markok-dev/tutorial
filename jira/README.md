## find everything yout worked on on any way
(summary ~ currentUser() OR description ~ currentUser() OR assignee = currentUser() OR worklogAuthor = currentUser() OR comment ~ currentUser() OR watcher = currentUser() OR text ~ currentUser() OR creator = currentUser() OR voter = currentUser()) AND status != done ORDER BY lastViewed DESC
