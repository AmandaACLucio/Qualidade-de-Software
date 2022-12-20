import { IMidiaGo } from '@/shared/model/midia-go.model';

export interface IMidiaGoProcess {
  id?: number;
  processInstance?: any | null;
  midiaGo?: IMidiaGo | null;
}

export class MidiaGoProcess implements IMidiaGoProcess {
  constructor(public id?: number, public processInstance?: any | null, public midiaGo?: IMidiaGo | null) {}
}
