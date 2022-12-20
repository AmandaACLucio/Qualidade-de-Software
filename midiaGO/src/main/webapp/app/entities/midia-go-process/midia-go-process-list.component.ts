import { Component, Vue, Inject } from 'vue-property-decorator';
import { IMidiaGoProcess } from '@/shared/model/midia-go-process.model';

import { ProcessDefinition, ProcessDefinitionService } from 'akip-vue-community';

import MidiaGoProcessService from './midia-go-process.service';

@Component
export default class MidiaGoProcessListComponent extends Vue {
  @Inject('midiaGoProcessService') private midiaGoProcessService: () => MidiaGoProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'MidiaGoProcess';
  public processDefinition: ProcessDefinition = new ProcessDefinition();
  public midiaGoProcessList: IMidiaGoProcess[] = [];

  public isFetchingProcessDefinition = false;
  public isFetchingProcessInstances = false;

  public mounted(): void {
    this.init();
  }

  public init(): void {
    this.retrieveProcessDefinition();
    this.retrieveProcessInstances();
  }

  public retrieveProcessDefinition() {
    this.isFetchingProcessDefinition = true;
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(
      res => {
        this.processDefinition = res;
        this.isFetchingProcessDefinition = false;
      },
      err => {
        this.isFetchingProcessDefinition = false;
      }
    );
  }

  public retrieveProcessInstances(): void {
    this.isFetchingProcessInstances = true;
    this.midiaGoProcessService()
      .retrieve()
      .then(
        res => {
          this.midiaGoProcessList = res.data;
          this.isFetchingProcessInstances = false;
        },
        err => {
          this.isFetchingProcessInstances = false;
        }
      );
  }

  get isFetching(): boolean {
    return this.isFetchingProcessDefinition && this.isFetchingProcessInstances;
  }

  public handleSyncList(): void {
    this.retrieveProcessInstances();
  }

  public previousState(): void {
    this.$router.go(-1);
  }
}
