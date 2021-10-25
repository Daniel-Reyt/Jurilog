import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';
//for DEV
//export const url = "http://localhost:8989/"
//-------------------------------------------------
//for PROD
export const url = "http://10.3.1.58:8989/"
if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => Error(err));
