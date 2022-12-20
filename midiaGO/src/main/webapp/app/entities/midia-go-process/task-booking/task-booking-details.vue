<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <h2 id="page-heading" data-cy="TaskInstanceHeading">
        <span v-text="$t('midiaGoApp.taskInstance.details.title')" id="task-instance-heading">Task Details</span>
      </h2>
      <div v-if="taskContext.taskInstance">
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('midiaGoApp.taskBooking.userName')">userName</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="userName"
                id="midia-go-userName"
                data-cy="userName"
                v-model="taskContext.midiaGoProcess.midiaGo.userName"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('midiaGoApp.taskBooking.startDate')">startDate</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="startDate"
                id="midia-go-startDate"
                data-cy="startDate"
                v-model="taskContext.midiaGoProcess.midiaGo.startDate"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('midiaGoApp.taskBooking.endDate')">endDate</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="endDate"
                id="midia-go-endDate"
                data-cy="endDate"
                v-model="taskContext.midiaGoProcess.midiaGo.endDate"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('midiaGoApp.taskBooking.mediaName')">mediaName</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="mediaName"
                id="midia-go-mediaName"
                data-cy="mediaName"
                v-model="taskContext.midiaGoProcess.midiaGo.mediaName"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('midiaGoApp.taskBooking.mediaBookingNumber')">mediaBookingNumber</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="mediaBookingNumber"
                id="midia-go-mediaBookingNumber"
                data-cy="mediaBookingNumber"
                v-model="taskContext.midiaGoProcess.midiaGo.mediaBookingNumber"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>

        <router-link
          v-if="taskContext.taskInstance.status == 'NEW' || taskContext.taskInstance.status == 'ASSIGNED'"
          :to="`/process-definition/MidiaGoProcess/task/TaskBooking/${taskContext.taskInstance.id}/execute`"
          tag="button"
          class="btn btn-primary"
          data-cy="entityDetailsButton"
        >
          <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;Execute
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./task-booking-details.component.ts"></script>
