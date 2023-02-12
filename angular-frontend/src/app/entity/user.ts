export class User {
  constructor(acc?: string, pass?: string, uid?: number) {
    this.uid = uid;
    this.uname = acc;
    this.upassword = pass;
  }

  uid?: number;
  uname?: string;
  upassword?: string;
  upassword_salt?: string;
  urealname?: string;
  uemail?: string;
  utelephone?: string;
  uaddress?: string;
  usex?: number;
  udate?: string;
  uidentity?: string;
  uactive?: number;
  ulevel?: number;
  ucookie?: string;
  ucookie_salt?: string;
  uverify?: string;
  statuss?: number;
  message?: string;
  lasttime?: number;
}
