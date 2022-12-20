import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

// prettier-ignore
const MidiaGo = () => import('@/entities/midia-go/midia-go.vue');
// prettier-ignore
const MidiaGoDetails = () => import('@/entities/midia-go/midia-go-details.vue');
// prettier-ignore
const MidiaGoProcessDetails = () => import('@/entities/midia-go-process/midia-go-process-details.vue');
// prettier-ignore
const MidiaGoProcessList = () => import('@/entities/midia-go-process/midia-go-process-list.vue');
// prettier-ignore
const MidiaGoStartFormInit = () => import('@/entities/midia-go-process/midia-go-start-form-init.vue');
// prettier-ignore
const MidiaGoProcess_TaskBookingDetails = () => import('@/entities/midia-go-process/task-booking/task-booking-details.vue');
// prettier-ignore
const MidiaGoProcess_TaskBookingExecute = () => import('@/entities/midia-go-process/task-booking/task-booking-execute.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
  {
    path: '/midia-go',
    name: 'MidiaGo',
    component: MidiaGo,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/midia-go/:midiaGoId/view',
    name: 'MidiaGoView',
    component: MidiaGoDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/MidiaGoProcess/instance/:processInstanceId/view',
    name: 'MidiaGoProcessView',
    component: MidiaGoProcessDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/MidiaGoProcess/instances',
    name: 'MidiaGoProcessList',
    component: MidiaGoProcessList,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/MidiaGoProcess/init',
    name: 'MidiaGoStartFormInit',
    component: MidiaGoStartFormInit,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/MidiaGoProcess/task/TaskBooking/:taskInstanceId/view',
    name: 'MidiaGoProcess_TaskBookingDetails',
    component: MidiaGoProcess_TaskBookingDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/MidiaGoProcess/task/TaskBooking/:taskInstanceId/execute',
    name: 'MidiaGoProcess_TaskBookingExecute',
    component: MidiaGoProcess_TaskBookingExecute,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
