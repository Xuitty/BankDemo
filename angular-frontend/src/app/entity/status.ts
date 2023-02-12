export class Status {
  constructor(statuss?: number, errorCode?: number, message?: string) {
    this.statuss = statuss;
    this.errorCode = errorCode;
    this.message = message;
  }
  statuss?: number;
  errorCode?: number;
  message?: string;
}
