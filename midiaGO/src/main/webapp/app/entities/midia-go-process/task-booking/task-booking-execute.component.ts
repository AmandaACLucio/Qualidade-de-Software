import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskBookingService from './task-booking.service';
import { TaskBookingContext } from './task-booking.model';

const validations: any = {
  taskContext: {
    midiaGoProcess: {
      midiaGo: {
        userName: {},
        startDate: {},
        endDate: {},
        mediaName: {},
        mediaBookingNumber: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskBookingExecuteComponent extends Vue {
  private taskBookingService: TaskBookingService = new TaskBookingService();
  private taskContext: TaskBookingContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskBookingService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskBookingService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
