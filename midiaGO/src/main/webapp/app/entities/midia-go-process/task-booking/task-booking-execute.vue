<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="taskContext.taskInstance">
        <h2 id="page-heading" data-cy="TaskInstanceHeading">
          <span v-text="$t('midiaGoApp.taskInstance.execute.title')" id="task-instance-heading">Task Execution</span>
        </h2>
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('midiaGoApp.taskBooking.userName')" for="task-booking-userName">User Name</label>
              <input
                type="text"
                class="form-control"
                name="userName"
                id="task-booking-userName"
                readonly
                data-cy="userName"
                :class="{
                  valid: !$v.taskContext.midiaGoProcess.midiaGo.userName.$invalid,
                  invalid: $v.taskContext.midiaGoProcess.midiaGo.userName.$invalid,
                }"
                v-model="$v.taskContext.midiaGoProcess.midiaGo.userName.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('midiaGoApp.taskBooking.startDate')" for="task-booking-startDate"
                >Start Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-booking-startDate"
                  readonly
                  data-cy="startDate"
                  type="text"
                  class="form-control"
                  name="startDate"
                  :class="{
                    valid: !$v.taskContext.midiaGoProcess.midiaGo.startDate.$invalid,
                    invalid: $v.taskContext.midiaGoProcess.midiaGo.startDate.$invalid,
                  }"
                  v-model="$v.taskContext.midiaGoProcess.midiaGo.startDate.$model"
                />
              </b-input-group>
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('midiaGoApp.taskBooking.endDate')" for="task-booking-endDate">End Date</label>
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-booking-endDate"
                  readonly
                  data-cy="endDate"
                  type="text"
                  class="form-control"
                  name="endDate"
                  :class="{
                    valid: !$v.taskContext.midiaGoProcess.midiaGo.endDate.$invalid,
                    invalid: $v.taskContext.midiaGoProcess.midiaGo.endDate.$invalid,
                  }"
                  v-model="$v.taskContext.midiaGoProcess.midiaGo.endDate.$model"
                />
              </b-input-group>
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('midiaGoApp.taskBooking.mediaName')" for="task-booking-mediaName"
                >Media Name</label
              >
              <input
                type="text"
                class="form-control"
                name="mediaName"
                id="task-booking-mediaName"
                data-cy="mediaName"
                :class="{
                  valid: !$v.taskContext.midiaGoProcess.midiaGo.mediaName.$invalid,
                  invalid: $v.taskContext.midiaGoProcess.midiaGo.mediaName.$invalid,
                }"
                v-model="$v.taskContext.midiaGoProcess.midiaGo.mediaName.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('midiaGoApp.taskBooking.mediaBookingNumber')"
                for="task-booking-mediaBookingNumber"
                >Media Booking Number</label
              >
              <input
                type="text"
                class="form-control"
                name="mediaBookingNumber"
                id="task-booking-mediaBookingNumber"
                data-cy="mediaBookingNumber"
                :class="{
                  valid: !$v.taskContext.midiaGoProcess.midiaGo.mediaBookingNumber.$invalid,
                  invalid: $v.taskContext.midiaGoProcess.midiaGo.mediaBookingNumber.$invalid,
                }"
                v-model="$v.taskContext.midiaGoProcess.midiaGo.mediaBookingNumber.$model"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <button type="submit" v-on:click.prevent="complete()" class="btn btn-success" data-cy="complete">
          <font-awesome-icon icon="check-circle"></font-awesome-icon>&nbsp;Complete
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./task-booking-execute.component.ts"></script>
