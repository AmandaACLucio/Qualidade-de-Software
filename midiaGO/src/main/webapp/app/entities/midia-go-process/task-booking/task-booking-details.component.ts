import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskBookingService from './task-booking.service';
import { TaskBookingContext } from './task-booking.model';

@Component
export default class TaskBookingDetailsComponent extends Vue {
  private taskBookingService: TaskBookingService = new TaskBookingService();
  private taskContext: TaskBookingContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskBookingService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
