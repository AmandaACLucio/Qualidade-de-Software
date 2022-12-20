<template>
  <div>
    <h2 id="page-heading" data-cy="MidiaGoHeading">
      <span v-text="$t('midiaGoApp.midiaGo.home.title')" id="midia-go-heading">Midia Gos</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('midiaGoApp.midiaGo.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && midiaGos && midiaGos.length === 0">
      <span v-text="$t('midiaGoApp.midiaGo.home.notFound')">No midiaGos found</span>
    </div>
    <div class="table-responsive" v-if="midiaGos && midiaGos.length > 0">
      <table class="table table-striped" aria-describedby="midiaGos">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('midiaGoApp.midiaGo.userName')">User Name</span></th>
            <th scope="row"><span v-text="$t('midiaGoApp.midiaGo.startDate')">Start Date</span></th>
            <th scope="row"><span v-text="$t('midiaGoApp.midiaGo.endDate')">End Date</span></th>
            <th scope="row"><span v-text="$t('midiaGoApp.midiaGo.mediaName')">Media Name</span></th>
            <th scope="row"><span v-text="$t('midiaGoApp.midiaGo.mediaBookingNumber')">Media Booking Number</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="midiaGo in midiaGos" :key="midiaGo.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'MidiaGoView', params: { midiaGoId: midiaGo.id } }">{{ midiaGo.id }}</router-link>
            </td>
            <td>{{ midiaGo.userName }}</td>
            <td>{{ midiaGo.startDate }}</td>
            <td>{{ midiaGo.endDate }}</td>
            <td>{{ midiaGo.mediaName }}</td>
            <td>{{ midiaGo.mediaBookingNumber }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'MidiaGoView', params: { midiaGoId: midiaGo.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span id="midiaGoApp.midiaGo.delete.question" data-cy="midiaGoDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-midiaGo-heading" v-text="$t('midiaGoApp.midiaGo.delete.question', { id: removeId })">
          Are you sure you want to delete this Midia Go?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-midiaGo"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeMidiaGo()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./midia-go.component.ts"></script>
