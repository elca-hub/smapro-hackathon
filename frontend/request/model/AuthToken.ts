import AuthRequestError from "./AuthRequestError";

export default class AuthToken {
  private readonly tokenStorageKey = 'token';

  private token;

  constructor() {
    let storageTokenValue = localStorage.getItem(this.tokenStorageKey);
    if (!storageTokenValue) storageTokenValue = '';

    this.token = storageTokenValue;
  }

  public getToken(): string {
    return this.token;
  }
}
