import { EatsepPage } from './app.po';

describe('eatsep App', function() {
  let page: EatsepPage;

  beforeEach(() => {
    page = new EatsepPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
