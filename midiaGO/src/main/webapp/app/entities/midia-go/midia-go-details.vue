<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="midiaGo">
        <h2 class="jh-entity-heading" data-cy="midiaGoDetailsHeading">
          <span v-text="$t('midiaGoApp.midiaGo.detail.title')">MidiaGo</span> {{ midiaGo.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('midiaGoApp.midiaGo.userName')">User Name</span>
          </dt>
          <dd>
            <span>{{ midiaGo.userName }}</span>
          </dd>
          <dt>
            <span v-text="$t('midiaGoApp.midiaGo.startDate')">Start Date</span>
          </dt>
          <dd>
            <span>{{ midiaGo.startDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('midiaGoApp.midiaGo.endDate')">End Date</span>
          </dt>
          <dd>
            <span>{{ midiaGo.endDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('midiaGoApp.midiaGo.mediaName')">Media Name</span>
          </dt>
          <dd>
            <span>{{ midiaGo.mediaName }}</span>
          </dd>
          <dt>
            <span v-text="$t('midiaGoApp.midiaGo.mediaBookingNumber')">Media Booking Number</span>
          </dt>
          <dd>
            <span>{{ midiaGo.mediaBookingNumber }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./midia-go-details.component.ts"></script>
