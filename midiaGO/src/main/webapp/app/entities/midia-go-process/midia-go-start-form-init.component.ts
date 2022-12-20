import { Component, Vue, Inject } from 'vue-property-decorator';

import { IMidiaGoProcess, MidiaGoProcess } from '@/shared/model/midia-go-process.model';

import { ProcessInstance, ProcessDefinitionService } from 'akip-vue-community';

import { MidiaGo } from '@/shared/model/midia-go.model';
import MidiaGoProcessService from './midia-go-process.service';

const validations: any = {
  midiaGoProcess: {
    midiaGo: {
      userName: {},
      startDate: {},
      endDate: {},
      mediaName: {},
    },
  },
};

@Component({
  validations,
})
export default class MidiaGoStartFormInitComponent extends Vue {
  @Inject('midiaGoProcessService') private midiaGoProcessService: () => MidiaGoProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'MidiaGoProcess';
  public midiaGoProcess: IMidiaGoProcess = new MidiaGoProcess();

  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      vm.initMidiaGoStartForm();
      vm.initRelationships();
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;

    this.midiaGoProcessService()
      .create(this.midiaGoProcess)
      .then(param => {
        this.isSaving = false;
        this.$router.go(-1);
        const message = this.$t('midiaGoApp.midiaGoStartForm.created', { param: param.id });
        this.$root.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Success',
          variant: 'success',
          solid: true,
          autoHideDelay: 5000,
        });
      });
  }

  public initMidiaGoStartForm(): void {
    this.midiaGoProcess.midiaGo = new MidiaGo();
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(res => {
      this.midiaGoProcess.processInstance = new ProcessInstance();
      this.midiaGoProcess.processInstance.processDefinition = res;
    });
  }
}
