/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import MidiaGoComponent from '@/entities/midia-go/midia-go.vue';
import MidiaGoClass from '@/entities/midia-go/midia-go.component';
import MidiaGoService from '@/entities/midia-go/midia-go.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('MidiaGo Management Component', () => {
    let wrapper: Wrapper<MidiaGoClass>;
    let comp: MidiaGoClass;
    let midiaGoServiceStub: SinonStubbedInstance<MidiaGoService>;

    beforeEach(() => {
      midiaGoServiceStub = sinon.createStubInstance<MidiaGoService>(MidiaGoService);
      midiaGoServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<MidiaGoClass>(MidiaGoComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          midiaGoService: () => midiaGoServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      midiaGoServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllMidiaGos();
      await comp.$nextTick();

      // THEN
      expect(midiaGoServiceStub.retrieve.called).toBeTruthy();
      expect(comp.midiaGos[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
