import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { NewoApp9MicroSharedModule } from 'app/shared';
import {
  PrepagoConsumoComponent,
  PrepagoConsumoDetailComponent,
  PrepagoConsumoUpdateComponent,
  PrepagoConsumoDeletePopupComponent,
  PrepagoConsumoDeleteDialogComponent,
  prepagoConsumoRoute,
  prepagoConsumoPopupRoute
} from './';

const ENTITY_STATES = [...prepagoConsumoRoute, ...prepagoConsumoPopupRoute];

@NgModule({
  imports: [NewoApp9MicroSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    PrepagoConsumoComponent,
    PrepagoConsumoDetailComponent,
    PrepagoConsumoUpdateComponent,
    PrepagoConsumoDeleteDialogComponent,
    PrepagoConsumoDeletePopupComponent
  ],
  entryComponents: [
    PrepagoConsumoComponent,
    PrepagoConsumoUpdateComponent,
    PrepagoConsumoDeleteDialogComponent,
    PrepagoConsumoDeletePopupComponent
  ],
  providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class NewoApp9MicroPrepagoConsumoModule {
  constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
    this.languageHelper.language.subscribe((languageKey: string) => {
      if (languageKey !== undefined) {
        this.languageService.changeLanguage(languageKey);
      }
    });
  }
}