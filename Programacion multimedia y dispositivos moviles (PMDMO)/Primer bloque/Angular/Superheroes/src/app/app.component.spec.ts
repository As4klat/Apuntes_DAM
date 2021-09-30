import { TestBed } from '@angular/core/testing';
import { Superheroes } from './app.component';

describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [
        Superheroes
      ],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(Superheroes);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'Superheroes'`, () => {
    const fixture = TestBed.createComponent(Superheroes);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('Superheroes');
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(Superheroes);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('.content span')?.textContent).toContain('Superheroes app is running!');
  });
});
