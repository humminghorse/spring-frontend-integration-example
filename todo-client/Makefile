STATIC_DIR = ../todo-app/src/main/resources/static

all: clean $(STATIC_DIR)/bundle.js $(STATIC_DIR)/style.css

$(STATIC_DIR)/bundle.js: node_modules $(STATIC_DIR)
	@node_modules/.bin/browserify scripts/main.js -o $@

$(STATIC_DIR)/style.css: node_modules $(STATIC_DIR)
	@node_modules/.bin/lessc styles/main.less $@

watch:
	$(MAKE) -j watch-js watch-less

watch-js: node_modules $(STATIC_DIR)
	@node_modules/.bin/watchify scripts/main.js -o $(STATIC_DIR)/bundle.js -v

watch-less: node_modules $(STATIC_DIR)
	@node_modules/.bin/watchf "styles/**/*.less" -c "node_modules/.bin/lessc styles/main.less $(STATIC_DIR)/style.css"

$(STATIC_DIR):
	@mkdir -p $@

clean:
	@rm -rf $(STATIC_DIR)

node_modules: package.json
	@npm install

.PHONY: all watch watch-js watch-less clean
