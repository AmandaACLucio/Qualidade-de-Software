<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="midiaGoApp.midiaGoStartForm.home.createOrEditLabel"
          data-cy="MidiaGoStartFormCreateUpdateHeading"
          v-text="$t('midiaGoApp.midiaGoStartForm.home.createOrEditLabel')"
        >
          Create or edit a MidiaGoStartForm
        </h2>
        <div v-if="midiaGoProcess.processInstance">
          <akip-show-process-definition :processDefinition="midiaGoProcess.processInstance.processDefinition">
            <template v-slot:body>
              <hr />
              <div v-if="midiaGoProcess.midiaGo">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('midiaGoApp.midiaGoStartForm.userName')" for="midia-go-start-form-userName"
                    >User Name</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="userName"
                    id="midia-go-start-form-userName"
                    data-cy="userName"
                    :class="{ valid: !$v.midiaGoProcess.midiaGo.userName.$invalid, invalid: $v.midiaGoProcess.midiaGo.userName.$invalid }"
                    v-model="$v.midiaGoProcess.midiaGo.userName.$model"
                  />
                </div>
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('midiaGoApp.midiaGoStartForm.startDate')" for="midia-go-start-form-startDate"
                    >Start Date</label
                  >
                  <b-input-group class="mb-3">
                    <b-input-group-prepend>
                      <b-form-datepicker
                        aria-controls="midia-go-start-form-startDate"
                        v-model="$v.midiaGoProcess.midiaGo.startDate.$model"
                        name="startDate"
                        class="form-control"
                        :locale="currentLanguage"
                        button-only
                        today-button
                        reset-button
                        close-button
                      >
                      </b-form-datepicker>
                    </b-input-group-prepend>
                    <b-form-input
                      id="midia-go-start-form-startDate"
                      data-cy="startDate"
                      type="text"
                      class="form-control"
                      name="startDate"
                      :class="{
                        valid: !$v.midiaGoProcess.midiaGo.startDate.$invalid,
                        invalid: $v.midiaGoProcess.midiaGo.startDate.$invalid,
                      }"
                      v-model="$v.midiaGoProcess.midiaGo.startDate.$model"
                    />
                  </b-input-group>
                </div>
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('midiaGoApp.midiaGoStartForm.endDate')" for="midia-go-start-form-endDate"
                    >End Date</label
                  >
                  <b-input-group class="mb-3">
                    <b-input-group-prepend>
                      <b-form-datepicker
                        aria-controls="midia-go-start-form-endDate"
                        v-model="$v.midiaGoProcess.midiaGo.endDate.$model"
                        name="endDate"
                        class="form-control"
                        :locale="currentLanguage"
                        button-only
                        today-button
                        reset-button
                        close-button
                      >
                      </b-form-datepicker>
                    </b-input-group-prepend>
                    <b-form-input
                      id="midia-go-start-form-endDate"
                      data-cy="endDate"
                      type="text"
                      class="form-control"
                      name="endDate"
                      :class="{ valid: !$v.midiaGoProcess.midiaGo.endDate.$invalid, invalid: $v.midiaGoProcess.midiaGo.endDate.$invalid }"
                      v-model="$v.midiaGoProcess.midiaGo.endDate.$model"
                    />
                  </b-input-group>
                </div>
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('midiaGoApp.midiaGoStartForm.mediaName')" for="midia-go-start-form-mediaName"
                    >Media Name</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="mediaName"
                    id="midia-go-start-form-mediaName"
                    data-cy="mediaName"
                    :class="{ valid: !$v.midiaGoProcess.midiaGo.mediaName.$invalid, invalid: $v.midiaGoProcess.midiaGo.mediaName.$invalid }"
                    v-model="$v.midiaGoProcess.midiaGo.mediaName.$model"
                  />
                </div>
              </div>
            </template>
          </akip-show-process-definition>
          <br />
          <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.midiaGoProcess.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;<span>Start</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./midia-go-start-form-init.component.ts"></script>
