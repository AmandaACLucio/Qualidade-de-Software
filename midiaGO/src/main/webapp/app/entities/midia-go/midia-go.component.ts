import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IMidiaGo } from '@/shared/model/midia-go.model';

import MidiaGoService from './midia-go.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class MidiaGo extends Vue {
  @Inject('midiaGoService') private midiaGoService: () => MidiaGoService;
  private removeId: number = null;

  public midiaGos: IMidiaGo[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllMidiaGos();
  }

  public clear(): void {
    this.retrieveAllMidiaGos();
  }

  public retrieveAllMidiaGos(): void {
    this.isFetching = true;

    this.midiaGoService()
      .retrieve()
      .then(
        res => {
          this.midiaGos = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
