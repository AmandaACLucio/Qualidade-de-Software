/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import MidiaGoDetailComponent from '@/entities/midia-go/midia-go-details.vue';
import MidiaGoClass from '@/entities/midia-go/midia-go-details.component';
import MidiaGoService from '@/entities/midia-go/midia-go.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('MidiaGo Management Detail Component', () => {
    let wrapper: Wrapper<MidiaGoClass>;
    let comp: MidiaGoClass;
    let midiaGoServiceStub: SinonStubbedInstance<MidiaGoService>;

    beforeEach(() => {
      midiaGoServiceStub = sinon.createStubInstance<MidiaGoService>(MidiaGoService);

      wrapper = shallowMount<MidiaGoClass>(MidiaGoDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { midiaGoService: () => midiaGoServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundMidiaGo = { id: 123 };
        midiaGoServiceStub.find.resolves(foundMidiaGo);

        // WHEN
        comp.retrieveMidiaGo(123);
        await comp.$nextTick();

        // THEN
        expect(comp.midiaGo).toBe(foundMidiaGo);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundMidiaGo = { id: 123 };
        midiaGoServiceStub.find.resolves(foundMidiaGo);

        // WHEN
        comp.beforeRouteEnter({ params: { midiaGoId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.midiaGo).toBe(foundMidiaGo);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        comp.previousState();
        await comp.$nextTick();

        expect(comp.$router.currentRoute.fullPath).toContain('/');
      });
    });
  });
});
