import { Component, Vue, Inject } from 'vue-property-decorator';

import { IMidiaGoProcess } from '@/shared/model/midia-go-process.model';
import MidiaGoProcessService from './midia-go-process.service';

@Component
export default class MidiaGoProcessDetailsComponent extends Vue {
  @Inject('midiaGoProcessService') private midiaGoProcessService: () => MidiaGoProcessService;
  public midiaGoProcess: IMidiaGoProcess = {};

  public isFetching: boolean = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.processInstanceId) {
        vm.retrieveMidiaGoProcess(to.params.processInstanceId);
      }
    });
  }

  public retrieveMidiaGoProcess(midiaGoProcessId) {
    this.isFetching = true;
    this.midiaGoProcessService()
      .find(midiaGoProcessId)
      .then(
        res => {
          this.midiaGoProcess = res;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public previousState() {
    this.$router.go(-1);
  }
}
