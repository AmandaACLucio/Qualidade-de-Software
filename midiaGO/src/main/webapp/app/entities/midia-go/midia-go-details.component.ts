import { Component, Vue, Inject } from 'vue-property-decorator';

import { IMidiaGo } from '@/shared/model/midia-go.model';
import MidiaGoService from './midia-go.service';

@Component
export default class MidiaGoDetails extends Vue {
  @Inject('midiaGoService') private midiaGoService: () => MidiaGoService;
  public midiaGo: IMidiaGo = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.midiaGoId) {
        vm.retrieveMidiaGo(to.params.midiaGoId);
      }
    });
  }

  public retrieveMidiaGo(midiaGoId) {
    this.midiaGoService()
      .find(midiaGoId)
      .then(res => {
        this.midiaGo = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
