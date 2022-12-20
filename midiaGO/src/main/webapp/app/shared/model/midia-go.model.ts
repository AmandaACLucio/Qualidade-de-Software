export interface IMidiaGo {
  id?: number;
  userName?: string | null;
  startDate?: Date | null;
  endDate?: Date | null;
  mediaName?: string | null;
  mediaBookingNumber?: string | null;
}

export class MidiaGo implements IMidiaGo {
  constructor(
    public id?: number,
    public userName?: string | null,
    public startDate?: Date | null,
    public endDate?: Date | null,
    public mediaName?: string | null,
    public mediaBookingNumber?: string | null
  ) {}
}
