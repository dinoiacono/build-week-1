import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeroComponent } from './components/hero/hero.component';
import { HeaderComponent } from './components/header/header.component';
import { ArchivioComponent } from './components/archivio/archivio.component';
import { PostComponent } from './components/post/post.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './components/home/home.component';
import { SinglePostComponent } from './components/single-post/single-post.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { AdminComponent } from './components/admin/admin.component';
import { FormsModule } from '@angular/forms';
import { TokenInterceptor } from './auth/token.interceptor';

@NgModule({
	declarations: [
		AppComponent,
		HeroComponent,
		HeaderComponent,
		ArchivioComponent,
		PostComponent,
		HomeComponent,
		SinglePostComponent,
		NotFoundComponent,
		AdminComponent
	],
	imports: [
		BrowserModule,
		AppRoutingModule,
		HttpClientModule,
		FormsModule,
	],
	providers: [
		{
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
		}
	],
	bootstrap: [AppComponent]
})
export class AppModule { }
