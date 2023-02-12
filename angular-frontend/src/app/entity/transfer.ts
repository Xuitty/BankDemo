import Decimal from 'decimal.js';

export class Transfer {
  sender_account?: string;
  receiver_bank_code?: number;
  receiver_account?: string;
  amount?: Decimal = new Decimal(-1); //do not use in front-end
  amount_string?: string;
  currency_type?: number;
  schedule?: boolean;
  schedule_time?: number;
  operate_time?: number;
  verify?: string;
}
