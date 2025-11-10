package golang_solutions

type TaskManager struct {
}

func (this *TaskManager) Add(userId int, taskId int, priority int) {

}

func (this *TaskManager) Edit(taskId int, newPriority int) {

}

func (this *TaskManager) Rmv(taskId int) {

}

func (this *TaskManager) ExecTop() int {
	return -1
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * obj := Constructor(tasks);
 * obj.Add(userId,taskId,priority);
 * obj.Edit(taskId,newPriority);
 * obj.Rmv(taskId);
 * param_4 := obj.ExecTop();
 */
