<template>
  <div>
    <h2 class="jh-entity-heading" data-cy="midiaGoProcessDetailsHeading">
      <span v-text="$t('midiaGoApp.midiaGoProcess.home.title')">MidiaGoProcess</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('midiaGoApp.midiaGoProcess.home.refreshListLabel')">Refresh List</span>
        </button>

        <router-link :to="`/process-definition/MidiaGoProcess/init`" tag="button" class="btn btn-primary mr-2">
          <font-awesome-icon icon="plus"></font-awesome-icon>
          <span v-text="$t('midiaGoApp.midiaGoProcess.home.createLabel')"> Create a new Travel Plan Process Instance </span>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && midiaGoProcessList && midiaGoProcessList.length === 0">
      <span v-text="$t('midiaGoApp.midiaGoProcess.home.notFound')">No midiaGoProcess found</span>
    </div>
    <div class="table-responsive" v-if="midiaGoProcessList && midiaGoProcessList.length > 0">
      <table class="table table-striped" aria-describedby="midiaGoProcessList">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span>Process Instance</span></th>
            <th scope="row"><span>Midia Go</span></th>
            <th scope="row"><span>Status</span></th>
            <th scope="row"><span>Start Date</span></th>
            <th scope="row"><span>End Date</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="midiaGoProcess in midiaGoProcessList" :key="midiaGoProcess.id" data-cy="entityTable">
            <td>{{ midiaGoProcess.id }}</td>
            <td>
              <div v-if="midiaGoProcess.processInstance">
                <router-link :to="`/process-definition/MidiaGoProcess/instance/${midiaGoProcess.processInstance.id}/view`">
                  {{ midiaGoProcess.processInstance.businessKey }}
                </router-link>
              </div>
            </td>
            <td>
              <div v-if="midiaGoProcess.midiaGo">
                <router-link :to="{ name: 'MidiaGoView', params: { midiaGoId: midiaGoProcess.midiaGo.id } }">{{
                  midiaGoProcess.midiaGo.id
                }}</router-link>
              </div>
            </td>
            <td>
              <akip-show-process-instance-status :status="midiaGoProcess.processInstance.status"></akip-show-process-instance-status>
            </td>
            <td>{{ midiaGoProcess.processInstance.startDate ? $d(Date.parse(midiaGoProcess.processInstance.startDate), 'short') : '' }}</td>
            <td>{{ midiaGoProcess.processInstance.endDate ? $d(Date.parse(midiaGoProcess.processInstance.endDate), 'short') : '' }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="`/process-definition/MidiaGoProcess/instance/${midiaGoProcess.processInstance.id}/view`"
                  tag="button"
                  class="btn btn-info btn-sm details"
                  data-cy="entityDetailsButton"
                >
                  <font-awesome-icon icon="eye"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
      <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
    </button>
  </div>
</template>

<script lang="ts" src="./midia-go-process-list.component.ts"></script>
