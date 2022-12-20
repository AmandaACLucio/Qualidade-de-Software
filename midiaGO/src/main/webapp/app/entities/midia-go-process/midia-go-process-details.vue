<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="midiaGoProcess.processInstance">
        <h2 class="jh-entity-heading" data-cy="midiaGoProcessDetailsHeading">
          <span v-text="$t('midiaGoApp.midiaGoProcess.detail.title')">MidiaGoProcess</span> {{ midiaGoProcess.id }}
        </h2>
        <akip-show-process-instance :processInstance="midiaGoProcess.processInstance">
          <template v-slot:title>
            <span v-text="$t('midiaGoApp.midiaGoProcess.detail.title')">MidiaGoProcess</span> #{{ midiaGoProcess.id }}
          </template>
          <template v-slot:details>
            <div class="card" v-if="midiaGoProcess.midiaGo">
              <h5 class="card-header">
                <span class="title"> Midia Go #{{ midiaGoProcess.midiaGo.id }} </span>
              </h5>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('midiaGoApp.midiaGoProcess.userName')">userName</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="userName"
                    id="midia-go-userName"
                    data-cy="userName"
                    v-model="midiaGoProcess.midiaGo.userName"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('midiaGoApp.midiaGoProcess.startDate')">startDate</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="startDate"
                    id="midia-go-startDate"
                    data-cy="startDate"
                    v-model="midiaGoProcess.midiaGo.startDate"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('midiaGoApp.midiaGoProcess.endDate')">endDate</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="endDate"
                    id="midia-go-endDate"
                    data-cy="endDate"
                    v-model="midiaGoProcess.midiaGo.endDate"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('midiaGoApp.midiaGoProcess.mediaName')">mediaName</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="mediaName"
                    id="midia-go-mediaName"
                    data-cy="mediaName"
                    v-model="midiaGoProcess.midiaGo.mediaName"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('midiaGoApp.midiaGoProcess.mediaBookingNumber')">mediaBookingNumber</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="mediaBookingNumber"
                    id="midia-go-mediaBookingNumber"
                    data-cy="mediaBookingNumber"
                    v-model="midiaGoProcess.midiaGo.mediaBookingNumber"
                  />
                </div>
              </div>
            </div>
          </template>
        </akip-show-process-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./midia-go-process-details.component.ts"></script>
