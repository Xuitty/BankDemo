export class Status {
  constructor(statuss?: number, message?: string) {
    this.statuss = statuss;
    this.message = message;
  }
  statuss?: number;
  message?: string;
}
